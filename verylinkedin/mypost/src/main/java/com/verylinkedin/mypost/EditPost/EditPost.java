package com.verylinkedin.mypost.EditPost;

import com.verylinkedin.mypost.Command;
import com.verylinkedin.mypost.PostRepository;
import com.verylinkedin.mypost.models.Post;

public record EditPost(EditPostRequest request, PostRepository postRepository) implements Command {
    public Object execute() {
        Post post = (Post) postRepository.findById(request.postId());
        post.setContent(request.content());

        postRepository.save(post);
        return null ;

    }
}
