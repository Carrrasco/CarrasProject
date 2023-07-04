package bluecode.carrasco.carrasproject.web;

import bluecode.carrasco.carrasproject.web.dto.SaludoDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/main", produces = MediaType.APPLICATION_JSON_VALUE)

public class MainController {


	@GetMapping(value = {"/hello"})
	@Transactional
	public ResponseEntity<SaludoDto> getSaludo() {
		checkIsDivisionAdmin(getAuthorizedDivision());
		SaludoDto saludo = getSubscriptionWithAccess(name)
				.map(subscriptionAdapter::mapToSubscriptionDto)
				.orElseThrow(() -> new SubscriptionNotFoundException(name));

		log.info("Subscription found: {}.", saludo);

		return ResponseEntity.ok(saludo);
	}
}
