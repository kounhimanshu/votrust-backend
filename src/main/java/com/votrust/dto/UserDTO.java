package com.votrust.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO{

    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String name;
    private String publicKey; // Store Base64 encoded public key
    private String privateKey; // Sent in API response, not saved in DB

}
/**
| Module # | Module Name                            | Description                                      |
        | -------- | -------------------------------------- | ------------------------------------------------ |
        | 1️⃣      | 🔐 **User Registration + RSA KeyPair** | Voter registration + RSA 2048-bit key generation |
        | 2️⃣      | 🗳️ **Election Setup (Admin)**         | Admin creates election + adds candidates         |
        | 3️⃣      | 🧾 **Vote Casting with Signature**     | Voter selects candidate + digitally signs vote   |
        | 4️⃣      | ⛓️ **Blockchain Vote Storage**         | Votes stored as blocks with hash, prevHash       |
        | 5️⃣      | 📊 **Vote Counting + Result**          | Show live results by reading blockchain          |
        | 6️⃣      | 🔍 **Blockchain Validation + Audit**   | Detect tampering, verify integrity               |
*/

/** //todo
 * | Task No | Task                                              | Status                    |
 * | ------- | ------------------------------------------------- | ------------------------- |
 * | 1.1     | Create `User` Entity + DTO                        | ✅ Done                    |
 * | 1.2     | Add `RSAUtil` for key generation                  | ✅ Done                    |
 * | 1.3     | Write `registerUser()` in `UserServiceImpl`       | ✅ Done                    |
 * | 1.4     | Create Controller Endpoint: `/api/users/register` | 🔄 Starting now           |
 * | 1.5     | Return success response with private key          | ⏭️ After controller       |
 * | 1.6     | Save public key in DB                             | 🔄 Already handled in 1.3 |
 * | 1.7     | Test in Postman                                   | 🔜 After API setup        |
 */


