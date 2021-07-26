package com.dietz.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/v1/user-data")
class UserDataController {
    @GetMapping
    Flux<Jwt> getAccounts(@AuthenticationPrincipal Jwt token) {
        Flux.just(token)
    }
}
