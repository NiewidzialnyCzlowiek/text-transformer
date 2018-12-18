package pl.put.poznan.transformer.rest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.Response;
import pl.put.poznan.transformer.logic.TransformerService;
import pl.put.poznan.transformer.logic.TransformRequestModel;

@Slf4j
@RestController
public class TextTransformerController {

    private final TransformerService transformerService;

    @Autowired
    public TextTransformerController(TransformerService transformerService) {
        this.transformerService = transformerService;
    }

    @CrossOrigin
    @PostMapping(value = "/transform")
    public Response transformText(@RequestBody @Validated TransformRequestModel requestModel) {
        Long startTime = System.currentTimeMillis();
        log.info(String.format("Received get with request model %s", requestModel));
        String transformed = transformerService.transform(requestModel);
        Long endTime = System.currentTimeMillis();
        return new Response(transformed, startTime - endTime);
    }
}


