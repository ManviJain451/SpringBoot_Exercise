package ResfulAPIsPart2.Controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @GetMapping
    public CollectionModel<EntityModel<String>> getAllTopics() {
        List<String> topics = Arrays.asList("Java", "Spring Boot", "HATEOAS", "REST APIs");

        List<EntityModel<String>> topicResources = topics.stream()
                .map(topic -> EntityModel.of(topic,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TopicController.class).getAllTopics())
                                .withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(topicResources);
    }
}
