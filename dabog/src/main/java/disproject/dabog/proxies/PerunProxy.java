package disproject.dabog.proxies;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="perun")
public interface PerunProxy {
	
	@PostMapping("/basket/close")
	public ResponseEntity<Object> closePerunBasket(@RequestParam(value="paymentRefId") String paymentRefId);

}
