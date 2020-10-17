package tech.costa.luiz.urlshortening.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.costa.luiz.urlshortening.service.ShorteningService;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.when;

/**
 * The type Shortening should.
 */
@ExtendWith(MockitoExtension.class)
class ShorteningShould {

    /**
     * The Service.
     */
    @Mock
    ShorteningService service;

    /**
     * Given an url generate a shorter and unique alias.
     *
     * @param original    the original
     * @param shorterLink the shorter link
     */
    @ParameterizedTest(name = "urls {0} has been shorted")
    @MethodSource("originalLinksToShortLinks")
    @DisplayName("Shortening URL")
    void givenAnURLGenerateAShorterAndUniqueAlias(String original, String shorterLink) {
        when(service.shortening(original)).thenReturn(shorterLink);
        final String shortedUrl = service.shortening(original);
        assertThat(shortedUrl, is(equalTo(shorterLink)));
    }

    /**
     * Redirect to original url.
     *
     * @param shortURL    the short url
     * @param originalURL the original url
     */
    @ParameterizedTest(name = "Redirect {0} to {1}")
    @MethodSource("shorterLinksOriginalLinks")
    @DisplayName("Redirect to original URL")
    void redirectToOriginalUrl(String shortURL, String originalURL) {
        when(service.toOriginal(shortURL)).thenReturn(originalURL);
        final String original = service.toOriginal(shortURL);
        assertThat(original, is(equalTo(originalURL)));
    }

    /**
     * Pick a custom short link.
     */
    @Test
    void pickACustomShortLink() {
        //FIXME
    }

    /**
     * Expire link after default timespan.
     */
    @Test
    void expireLinkAfterDefaultTimespan() {
        //FIXME
    }

    /**
     * Expire link after custom timespan.
     *
     * @param timespan the timespan
     */
    @ParameterizedTest
    @CsvSource({"-1"})
    void expireLinkAfterCustomTimespan(long timespan) {
        //FIXME
    }

    /**
     * Shorter links original links stream.
     *
     * @return the stream
     */
    static Stream<Arguments> shorterLinksOriginalLinks() {
        return Stream.of(
                arguments("lg.oc/lctdp", "luizcosta.tech/designpatterns"),
                arguments("lg.oc/lgcep", "lugocast.com/episodes")
        );
    }

    /**
     * Original links to short links stream.
     *
     * @return the stream
     */
    static Stream<Arguments> originalLinksToShortLinks() {
        return Stream.of(
                arguments("luizcosta.tech/designpatterns", "lg.oc/lctdp"),
                arguments("lugocast.com/episodes", "lg.oc/lgcep")
        );
    }

}