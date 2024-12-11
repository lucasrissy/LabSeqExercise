package com.example.AlticeLabsExercise.controller;


import com.example.AlticeLabsExercise.dto.ErrorResponseDto;
import com.example.AlticeLabsExercise.exception.InvalidData;
import com.example.AlticeLabsExercise.service.LabSeqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "LabSeq REST API",
        description = "A REST API to calculate and retrieve values of the LabSeq sequence, allowing the generation of lists based on the provided index."
)
@RestController
@RequestMapping("/labseq")
public class LabSeqController {


    private final LabSeqService labSeqService;

    @Autowired
    public LabSeqController(LabSeqService labSeqService) {
        this.labSeqService = labSeqService;
    }


    @Operation(
            summary = "Retrieve LabSeq Numbers",
            description = "REST API to calculate and retrieve values of the LabSeq sequence based on a given index."

    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved the LabSeq values.",
                    content = @Content(
                            mediaType = "4",
                            examples = {
                                    @ExampleObject(value = "[\n" +
                                            "    0,\n" +
                                            "    1,\n" +
                                            "    0,\n" +
                                            "    1,\n" +
                                            "    1\n" +
                                            "]")
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input provided.",
                    content = @Content(
                            mediaType = "-1",
                            schema = @Schema(implementation = ErrorResponseDto.class),
                            examples = {
                                    @ExampleObject(value = "{\n" +
                                            "  \"apiPath\": \"uri=/labseq/-1\",\n" +
                                            "  \"errorCode\": \"BAD_REQUEST\",\n" +
                                            "  \"errorMessage\": \"LabSeq is not valid with the given input data n : '-1'\",\n" +
                                            "  \"errorTime\": \"2024-12-11T19:02:31.5898166\"\n" +
                                            "}")
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "An internal server error occurred while processing the request.",
                    content = @Content(
                            mediaType = "application/json.",
                            schema = @Schema(implementation = ErrorResponseDto.class),
                            examples = {
                            @ExampleObject(value = "{\n" +
                                    "  \"apiPath\": \"uri=/labseq/-1\",\n" +
                                    "  \"errorCode\": \"INTERNAL_SERVER_ERROR\",\n" +
                                    "  \"errorMessage\": \" An error occurred while processing the request\",\n" +
                                    "  \"errorTime\": \"2024-12-11T19:02:31.5898166\"\n" +
                                    "}")
                    }
                    )
            )
    })

    @GetMapping("/{n}")
    public ResponseEntity<List<Integer>> getLabseq(@PathVariable Integer n) {

        if (n == null) {
            throw new InvalidData("LabSeq", "n", null);
        }

        if (n < 0) {
            throw new InvalidData("LabSeq", "n",n);
        }

        return ResponseEntity.ok(labSeqService.generateLabseq(n));
    }
}
