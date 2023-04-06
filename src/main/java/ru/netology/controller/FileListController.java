package ru.netology.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dto.FileDescriptionResponse;
import ru.netology.service.AuthService;
import ru.netology.service.FileService;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/list")
@Validated
public class FileListController {
    private final FileService fileService;
    private final AuthService authService;

    public FileListController(FileService fileService, AuthService authService) {
        this.fileService = fileService;
        this.authService = authService;
    }

    @GetMapping
    public List<FileDescriptionResponse> getFileList(@RequestHeader("auth-token") @NotBlank String authToken, @Min(1) int limit) {
        authService.checkToken(authToken);
        return fileService.getFileList(limit);
    }
}
