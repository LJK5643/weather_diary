package com.self.weatherdiary.controller;

import com.self.weatherdiary.domain.Diary;
import com.self.weatherdiary.service.DiaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

@RestController
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @Operation(summary = "일기 생성 API", description = "일기를 생성하는 API 입니다.")
    @PostMapping("/create/diary")
    void createDiary(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) @Parameter(description = "날짜 형식 : yyyy-MM-dd", example = "2022-02-02") LocalDate date, @RequestBody String text) {
        diaryService.createDiary(date, text);
    }

    @Operation(summary = "특정 날짜 일기 조회 API", description = "특정 날짜 일기를 조회하는 API 입니다.")
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date) {
        return diaryService.readDiary(date);
    }

    @Operation(summary = "전체 일기 조회 API", description = "전체 일기를 조회하는 API 입니다.")
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) @Parameter(description = "조회할 기간의 첫번째날") LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) @Parameter(description = "조회할 기간의 마지막날") LocalDate endDate) {
        return diaryService.readDiaris(startDate, endDate);
    }

    @Operation(summary = "일기 수정 API", description = "특정 날짜의 일기를 수정하는 API 입니다.")
    @PutMapping("/update/diary")
    void updateDiary(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) @Parameter(description = "날짜 형식 : yyyy-MM-dd", example = "2022-02-02") LocalDate date, @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    @Operation(summary = "일기 삭제 API", description = "해당 날짜의 일기를 모두 삭제하는 API 입니다.")
    @DeleteMapping("/delete/diary")
    void deleteDiary(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) @Parameter(description = "날짜 형식 : yyyy-MM-dd", example = "2022-02-02") LocalDate date) {
        diaryService.deleteDiary(date);
    }
}
