package files;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelenideFilesTest {
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
