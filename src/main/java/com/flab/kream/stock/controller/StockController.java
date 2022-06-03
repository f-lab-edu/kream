package com.flab.kream.stock.controller;

import com.flab.kream.stock.dto.StockRequestDTO;
import com.flab.kream.stock.dto.StockResponseDTO;
import com.flab.kream.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockResponseDTO>> selectStock(@Validated @RequestBody StockRequestDTO stockRequest) {
        stockService.selectStock(stockRequest);
        return new ResponseEntity<List<StockResponseDTO>>(HttpStatus.OK);
    }
}