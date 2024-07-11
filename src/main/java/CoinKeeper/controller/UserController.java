package CoinKeeper.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CoinKeeper.dto.request.IDUserRequest;
import CoinKeeper.dto.request.UpdateUserStatusRequest;
import CoinKeeper.dto.request.UserRequest;
import CoinKeeper.dto.response.UserResponse;
import CoinKeeper.service.user.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/coinkeeper/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService service;

    @GetMapping("/findbyid")
    public ResponseEntity<UserResponse> findById(@RequestBody IDUserRequest userID) {
        return ResponseEntity.ok().body(service.findById(userID.getId()));
    }

    @GetMapping("/findall")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // @PostMapping("/register")
    // public ResponseEntity<UserResponse> register(@RequestBody UserRequest
    // userRequest) {
    // return ResponseEntity.ok().body(service.register(userRequest));
    // }

    @PutMapping("/update")
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest userRequest,
            @PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok().body(service.update(userRequest, id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody IDUserRequest userID) {
        return ResponseEntity.ok().body(service.deleteById(userID.getId()));
    }

    @PostMapping("/updatestatus")
    public ResponseEntity<UserResponse> updateUserStatus(@RequestBody UpdateUserStatusRequest userStatusRequest) {
        service.updateUserStatus(userStatusRequest.getId(), userStatusRequest.getCode());
        return ResponseEntity.ok().body(new UserResponse(service.findUserById(userStatusRequest.getId())));
    }
}
