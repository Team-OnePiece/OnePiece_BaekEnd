package com.example.onepiece.domain.board.service;


import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.presentation.dto.response.CreateBoardResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.infra.s3.service.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CreateBoardService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;
    private final S3Facade s3Facade;

    @Transactional
    public CreateBoardResponse createBoard(String place, MultipartFile boardImage) {

        User currentUser = userFacade.getCurrentUser();
        Board board = boardRepository.save(
                Board.builder()
                        .user(currentUser)
                        .starCounts(0)
                        .place(place)
                        .build()
        );

        String boardImageUrl = s3Facade.uploadImage(boardImage);
        board.imageUpload(boardImageUrl);

        return new CreateBoardResponse(board.getId());
    }

}