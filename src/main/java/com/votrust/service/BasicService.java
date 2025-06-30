package com.votrust.service;


import com.votrust.dto.PageDTO;
import com.votrust.exception.CommonExceptions;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class BasicService<E, D> {

    private final Class<E> entityType;
    private final Class<D> dtoType;
    //@Value("${page.default-number}")
    protected int defaultPage;
    //@Value("${page.default-size}")
    protected int defaultSize;
    private JpaRepository<E, Integer> basicRepository;
    private ModelMapper modelMapper;


    public BasicService(Class<E> entityType, Class<D> dtoType) {
        this.entityType = entityType;
        this.dtoType = dtoType;
    }

    public D saveOrUpdate(D d) {
        try {
            E e = basicRepository.saveAndFlush(dtoToEntity(d));
            return entityToDto(e);
        } catch (DataIntegrityViolationException ex) {
            throw new CommonExceptions.ResourceAlreadyExistException("RESOURCE_EXIST_MESSAGE");
        }
    }


    public D get(Integer id) {
        return entityToDto(getEntity(id));
    }

    public void delete(Integer id) {
        basicRepository.delete(dtoToEntity(get(id)));
    }

    public List<D> findAll() {
        return entityToDtoList(basicRepository.findAll());
    }

    public List<D> findAllByCreatedDate() {
        return entityToDtoList(basicRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate")));
    }

    public List<E> getEntityList() {
        return basicRepository.findAll();
    }

    public D entityToDto(E e) {
        return modelMapper.map(e, this.dtoType);
    }

    public E dtoToEntity(D d) {
        return modelMapper.map(d, this.entityType);
    }

    public List<D> entityToDtoList(List<E> list) {
        return list.stream().map(e -> entityToDto(e)).collect(Collectors.toList());
    }

    public List<E> dtoToEntityList(List<D> list) {
        return list.stream().map(d -> dtoToEntity(d)).collect(Collectors.toList());
    }

    public E getEntity(Integer id) {
        Optional<E> t = basicRepository.findById(id);
        if (t.isPresent()) {
            return t.get();
        } else {
            throw new CommonExceptions.ResourceNotFoundException(id, "Data not found");
        }
    }

    public E save(E e) {
        System.out.println("20A");
        System.out.println("E ::" + e);
        try {
            System.out.println("20B");
            E entity = basicRepository.saveAndFlush(e);
            System.out.println("20C");
            return entity;
        } catch (DataIntegrityViolationException ex) {
            System.out.println("20D");
            throw new CommonExceptions.ResourceAlreadyExistException("RESOURCE_EXIST_MESSAGE");
        }
    }

    public Set<D> entityToDtoSet(Set<E> list) {
        return list.stream().map(e -> entityToDto(e)).collect(Collectors.toSet());
    }

    public Set<E> dtoToEntitySet(Set<D> list) {
        return list.stream().map(d -> dtoToEntity(d)).collect(Collectors.toSet());
    }

    public List<E> saveAllEntity(List<E> list) {
        return basicRepository.saveAll(list);
    }

    public List<D> saveAll(List<D> list) {
        return entityToDtoList(basicRepository.saveAll(dtoToEntityList(list)));
    }

    public void deleteAll(Iterable<? extends E> entities) {
        basicRepository.deleteAll(entities);
    }

    public PageRequest getPageRequest(PageDTO pageDto) {
        int page = Objects.nonNull(pageDto.getPage()) ? pageDto.getPage() : defaultPage;
        int size = Objects.nonNull(pageDto.getSize()) ? pageDto.getSize() : defaultSize;
        return PageRequest.of(page, size);
    }

    public PageRequest getPageRequest(PageDTO pageDto, Sort.Direction sortingOrder, String field) {
        int page = Objects.nonNull(pageDto.getPage()) ? pageDto.getPage() : defaultPage;
        int size = Objects.nonNull(pageDto.getSize()) ? pageDto.getSize() : defaultSize;
        return PageRequest.of(page, size, Sort.by(sortingOrder, field));
    }
}

