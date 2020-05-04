package pl.vladek.twitterWorkshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.vladek.twitterWorkshop.entity.*;

@Service
@Transactional
public class HomeService {

    private UserService userService;
    private TweetService tweetService;
    private CommentService commentService;
    private MessageService messageService;
    private MessageLabelService messageLabelService;
    private MessagePatternService messagePatternService;

    @Autowired
    public HomeService(
            UserService userService,
            TweetService tweetService,
            CommentService commentService,
            MessageService messageService,
            MessageLabelService messageLabelService,
            MessagePatternService messagePatternService) {
        this.userService = userService;
        this.tweetService = tweetService;
        this.commentService = commentService;
        this.messageService = messageService;
        this.messageLabelService = messageLabelService;
        this.messagePatternService = messagePatternService;
    }

    public void startTestDB() {
        createUsers();
        createTweets();
        createComments();
        createMessages();
        createMessageLabels();
        createMessagePatterns();
    }

    public void createUsers() {
        userService.save(new User("Piotr", "Nowak", "piotrnowak@gmail.com", "qwerty"));
        userService.save(new User("Jolanta", "Kowalska", "jolantakowalska@wp.pl", "qwerty"));
        userService.save(new User("Jan", "Kowalski", "jankowalski@onet.pl", "qwerty"));
        userService.save(new User("Kasia", "Glinka", "kasiaglinka@yahoo.com", "qwerty"));
        userService.save(new User("Maciej", "Sitek", "maciejsitek@wp.pl", "qwerty"));
        userService.save(new User("GuestName", "GuestSurname", "guest@test.pl", "guest"));
    }

    public void createTweets() {

        tweetService.save(new Tweet(userService.loadById(Long.parseLong("1")).get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        tweetService.save(new Tweet(userService.loadById(Long.parseLong("2")).get(), "Ac tortor vitae purus faucibus ornare suspendisse sed nisi."));
        tweetService.save(new Tweet(userService.loadById(Long.parseLong("3")).get(), "Mus mauris vitae ultricies leo integer malesuada nunc vel risus."));
        tweetService.save(new Tweet(userService.loadById(Long.parseLong("4")).get(), "Augue eget arcu dictum varius duis at consectetur lorem donec."));
        tweetService.save(new Tweet(userService.loadById(Long.parseLong("5")).get(), "Magna sit amet purus gravida quis blandit turpis cursus in."));
    }

    public void createComments() {
        commentService.save(
                new Comment(
                        userService.loadById(Long.parseLong("1")).get(),
                        tweetService.loadById(Long.parseLong("1")),
                        "Hello!"
                )
        );
        commentService.save(
                new Comment(
                        userService.loadById(Long.parseLong("2")).get(),
                        tweetService.loadById(Long.parseLong("1")),
                        "Nice"
                )
        );
    }

    public void createMessages() {
        messageService.save(
                new Message(
                        userService.loadById(Long.parseLong("1")).get(),
                        userService.loadById(Long.parseLong("2")).get(),
                        "Great"
                )
        );
    }

    public void createMessageLabels () {
        messageLabelService.save(new MessageLabel("green label", "label with low important", "green"));
        messageLabelService.save(new MessageLabel("yellow label", "label with medium important", "yellow"));
        messageLabelService.save(new MessageLabel("red label", "label with high important", "red"));
    }

    public void createMessagePatterns() {
        MessagePattern messagePattern;

        messagePattern = new MessagePattern();
        messagePattern.setTitle("Private message");
        messagePattern.setText("Dear friend, ...");
        messagePattern.addMessageLabel(messageLabelService.loadById(Long.parseLong("1")));
        messagePatternService.save(messagePattern);

        messagePattern = new MessagePattern();
        messagePattern.setTitle("Business formal message");
        messagePattern.setText("Dear Sir/Madame, ...");
        messagePattern.addMessageLabel(messageLabelService.loadById(Long.parseLong("3")));
        messagePatternService.save(messagePattern);

        messagePattern = new MessagePattern();
        messagePattern.setTitle("Business informal message");
        messagePattern.setText("Dear colleague, ...");
        messagePattern.addMessageLabel(messageLabelService.loadById(Long.parseLong("1")));
        messagePattern.addMessageLabel(messageLabelService.loadById(Long.parseLong("3")));
        messagePatternService.save(messagePattern);
    }

}