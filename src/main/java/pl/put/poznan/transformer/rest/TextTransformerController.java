package pl.put.poznan.transformer.rest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.Response;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.TransformRequestModel;

@Slf4j
@RestController
public class TextTransformerController {

    private final TextTransformer textTransformer;

    @Autowired
    public TextTransformerController(TextTransformer textTransformer) {
        this.textTransformer = textTransformer;
    }

    @CrossOrigin
    @PostMapping(value = "/transform")
    public Response transformText(@RequestBody @Validated TransformRequestModel requestModel) {
        log.debug(String.format("Received get with request model %s", requestModel));
        return new Response(textTransformer.transform(requestModel));
    }

}


