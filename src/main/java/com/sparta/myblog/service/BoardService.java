package com.sparta.myblog.service;

import com.sparta.myblog.models.Board;
import com.sparta.myblog.models.BoardRepository;
import com.sparta.myblog.models.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }
}
