package com.sparta.myblog.controller;

import com.sparta.myblog.models.Board;
import com.sparta.myblog.models.BoardRepository;
import com.sparta.myblog.models.BoardRequestDto;
import com.sparta.myblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @PostMapping("/api/myblog")
    public Board createBoard(@RequestBody BoardRequestDto requestDto){
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/myblog")
    public List<Board> getBoard(){
        return boardRepository.findAll();
    }

    @DeleteMapping("/api/myblog/{id}")
    public Long deleteBoard(@PathVariable Long id){
        boardRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/myblog/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.update(id, requestDto);
    }
}
