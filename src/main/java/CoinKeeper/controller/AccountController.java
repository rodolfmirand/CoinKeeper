package CoinKeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CoinKeeper.dto.request.BalanceLimitUpdateRequest;
import CoinKeeper.dto.response.AccountResponse;
import CoinKeeper.service.account.AccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/coinkeeper/account")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private final AccountService accountService;

    @PostMapping("/updatelimit")
    public ResponseEntity<AccountResponse> updateBalanceLimit(
            @RequestBody BalanceLimitUpdateRequest balanceLimitUpdateRequest) {
        return ResponseEntity.ok().body(accountService.updateBalanceLimit(balanceLimitUpdateRequest.getId_account(),
                balanceLimitUpdateRequest.getAmount()));
    }
}
