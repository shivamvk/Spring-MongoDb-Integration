# Spring-MongoDb-Integration
A rest api for login and signup with using framework springboot and database mongodb

Mappings are:

  **@PostMapping(value="/login")**<br>
  public Object Login(@RequestParam String email, @RequestParam String password);
  <br><br>
  
  **@PostMapping(value="/signup")**<br>
  public Object Signup(@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String phone);
  <br><br>
  
  **@PostMapping(value="/users/{userid}/address")**<br>
  public Object saveAddress(@PathVariable String userid,
			@RequestParam String address,
			@RequestParam String city,
			@RequestParam String state,
			@RequestParam String country);
  <br>    <br>
  
  **@GetMapping(value="/ListUsers")**<br>
  public List<User> getAllUsers();
