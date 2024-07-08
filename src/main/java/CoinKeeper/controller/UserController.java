package CoinKeeper.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CoinKeeper.dto.request.BalanceLimitUpdateRequest;
import CoinKeeper.dto.request.UserRequest;
import CoinKeeper.dto.response.AccountResponse;
import CoinKeeper.dto.response.UserResponse;
import CoinKeeper.service.account.AccountService;
import CoinKeeper.service.user.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/coinkeeper/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService service;

    @Autowired
    private final AccountService accountService;

    // admin
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    // admin
    @GetMapping()
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    //remover?
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok().body(service.register(userRequest));
    }

    //admin -> todos
    //user -> apenas ele próprio
    @PostMapping("/conta/limite")
    public ResponseEntity<AccountResponse> updateBalanceLimit(
            @RequestBody BalanceLimitUpdateRequest balanceLimitUpdateRequest) {
        return ResponseEntity.ok().body(accountService.updateBalanceLimit(balanceLimitUpdateRequest.getId_account(),
                balanceLimitUpdateRequest.getAmount()));
    }

    // admin -> todos
    // user -> apenas ele próprio
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest userRequest,
            @PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok().body(service.update(userRequest, id));
    }

    // admin -> todos
    // user -> apenas ele próprio
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok().body(service.deleteById(id));
    }
}
