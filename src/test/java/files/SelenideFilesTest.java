package files;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelenideFilesTest {
    public SelenideElement inputFile = $("input[qq-button-id='a76480db-11c2-4f48-91bf-a0539376ce20']");

    public SelenideElement inputFile2 = $x("//input[contains(@qq-button-id, 'db')]");


    @Test
    void selenideDownloadTest() throws IOException {
        open("https://github.com/assertj/assertj/blob/main/README.md");
        File downloadedFile = $("#raw-url").download();

        byte[] bytes;
        try (InputStream is = new FileInputStream(downloadedFile)) {
            bytes = is.readAllBytes();
        }
        String textContext = new String(bytes, StandardCharsets.UTF_8);
        assertThat(textContext).contains("AssertJ - Fluent Assertions");
    }

    @Test
    void selenideUploadTest() {
        open("https://fineuploader.com/demos");
        $("input[type='file']").uploadFromClasspath("img/1.png");
    }
}
