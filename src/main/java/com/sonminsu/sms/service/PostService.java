package com.sonminsu.sms.service;

import com.sonminsu.sms.DataNotFoundException;
import com.sonminsu.sms.model.Post;
import com.sonminsu.sms.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;


    public List<Post> getList() {
        return this.postRepository.findAll();
    }


    public Post getPost(Integer postId) {
        Optional<Post> post = this.postRepository.findById(postId);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new DataNotFoundException("post not found");
        }
    }

    //저장
        public void create(String subject){ //, String imagePath
        Post post = new Post();
        post.setSubject(subject);
        //post.setImagePath(imagePath);
        post.setCreateDate(LocalDateTime.now());
        this.postRepository.save(post);
    }

    /*
    //uploadImage 메소드 구현
    public String uploadImage(MultipartFile image) {
        try {
            // 이미지를 저장할 디렉토리를 생성합니다.
            Path uploadDir = Path.of("uploads");
            Files.createDirectories(uploadDir);

            // 이미지 파일의 이름을 지정합니다.
            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();

            // 이미지를 서버에 저장합니다.
            Path targetPath = uploadDir.resolve(fileName);
            Files.copy(image.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

            // 저장된 파일의 상대 경로를 반환합니다.
            return "uploads/" + fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to store image file", ex);
        }
    }
    */
}
