package com.github.fporto.design_patterns_lab.service;

import com.github.fporto.design_patterns_lab.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @RequestMapping(method = RequestMethod.GET, value = "/{zip}/json/")
    Address findByZip(@PathVariable("zip") String zip);
}
