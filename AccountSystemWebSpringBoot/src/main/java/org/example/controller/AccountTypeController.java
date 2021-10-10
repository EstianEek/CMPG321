package org.example.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.logic.flow.CreateAccountTypeFlow;
import org.example.logic.flow.FetchAccountTypeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.service.GeneralResponse;

import java.util.List;

@RestController
@RequestMapping("account-type")
public class AccountTypeController{

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;
//    private final ModifyAccountTypeFlow modifyAccountTypeFlow;


    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow, @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow/*, ModifyAccountTypeFlow modifyAccountTypeFlow*/){
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
//        this.modifyAccountTypeFlow = modifyAccountTypeFlow;
    }



    @GetMapping("/All")
    @ApiOperation(value = "Gets all the configured Account types", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account type returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll(){
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType", notes = "Creates a new AccountType in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Account type was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new Account.", required = true)
            @RequestBody AccountTypeDto accountType){
        List<AccountTypeDto> accountTypeResponse = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<AccountTypeDto>(true, (AccountTypeDto) accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{mnemomic}")
    @ApiOperation(value = "Fetches the specified AccountType", notes = "Fetches the AccountType corresponding to the give mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType",
            example = "MILES",
            name = "mnemonic",
            required = true)
            @PathVariable("mnemonic") final String mnemonic){

        AccountTypeDto accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);

        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}

