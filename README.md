# Spring-MongoDb-Integration
A rest api for login and signup with using framework springboot and database mongodb

Mappings are:

  @PostMapping(value="/login")
	public Object Login(@RequestParam String email, @RequestParam String password);
  
  @PostMapping(value="/signup")
	public Object Signup(@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String phone);
      
  @PostMapping(value="/users/{userid}/address")
	public Object saveAddress(@PathVariable String userid,
			@RequestParam String address,
			@RequestParam String city,
			@RequestParam String state,
			@RequestParam String country);
      
  @GetMapping(value="/ListUsers")
	public List<User> getAllUsers();
