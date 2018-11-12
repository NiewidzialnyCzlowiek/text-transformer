package pl.put.poznan.transformer.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.TransformRequestModel;

@RestController
public class TextTransformerController {

    private final TextTransformer textTransformer;

    @Autowired
    public TextTransformerController(TextTransformer textTransformer) {
        this.textTransformer = textTransformer;
    }

    @PostMapping(value = "/transform")
    public String transformText(@RequestBody @Validated TransformRequestModel requestModel) {
        return textTransformer.transform(requestModel);
    }

    @GetMapping(value = "/test")
    public String transformText() {
        return "test";
    }



}


