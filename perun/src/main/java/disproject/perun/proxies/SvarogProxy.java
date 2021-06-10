package disproject.perun.proxies;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="svarog")
public interface SvarogProxy {

	//@GetMapping("/items/{ean}")
	
}
