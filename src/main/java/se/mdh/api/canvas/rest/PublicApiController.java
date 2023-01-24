package se.mdh.api.canvas.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Klass som hanterar rest-gränssnittet för denna IC.
 */
@RestController
@RequestMapping("/v1/canvas")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "API för Canvas")
public class PublicApiController {
  private static final Log log = LogFactory.getLog(PublicApiController.class);

  static final String PUBLIC_API_READ = "SCOPE_public_api_read";

  public PublicApiController() {
  }

  @Operation(summary = "Ta emot en händelse från Canvas")
  @PostMapping(value = "event", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<String> receiveCanvasEvent(@RequestBody String event) {
    String logInfo = "POST /canvas";
    log.info(logInfo);
    log.info("Event mottaget: " + event);
    return new ResponseEntity<>(event, HttpStatus.OK);
  }
}
