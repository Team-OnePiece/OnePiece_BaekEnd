package com.example.onepiece.domain.board.presentation;

import com.example.onepiece.domain.board.presentation.dto.response.BoardReadResponse;
import com.example.onepiece.domain.board.presentation.dto.response.BoardCreateResponse;
import com.example.onepiece.domain.board.service.BoardCreateService;
import com.example.onepiece.domain.board.service.FindAllBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardCreateService boardCreateService;
    private final FindAllBoardService findAllBoardService;

    @PostMapping
    public BoardCreateResponse writeBoard(@RequestParam("place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        return boardCreateService.writeBoard(place, image);
    }

    @GetMapping("/all")
    public List<BoardReadResponse> findBoardAll() {
        return findAllBoardService.findAllBoards();
    }
}
