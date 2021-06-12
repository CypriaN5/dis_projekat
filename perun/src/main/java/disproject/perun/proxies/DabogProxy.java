package disproject.perun.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import disproject.perun.models.AppUser;

@FeignClient(name="dabog")
public interface DabogProxy {
	
	@PostMapping  ("/user") 
	public ResponseEntity<Object> addUser(@RequestBody AppUser user);
}
