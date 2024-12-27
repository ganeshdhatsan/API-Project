package API_Theory;

public class API_Theory {
	/**
	 * Authentication:
       RESTful APIs are usually stateless, 
       which means sessions or cookies should not be used. 
       Therefore, each request should come with some sort of authentication credentials.
       A common practice is to send a secret access token 
       with each request to authenticate the user. 
       Since an access token can be used to uniquely identify and authenticate a user,
       API requests should always be sent via HTTPS 
       to prevent man-in-the-middle (MitM) attacks.
	 */
/*
	1. JSON String Approach
	Pros:
	Simple to implement for static or rarely changing data.
	Easy to copy and paste directly from API documentation.
	Cons:
	Hard to manage for large or complex JSON payloads.
	Difficult to modify dynamically for varying test scenarios.
	No validation during compilation; errors may appear only at runtime.
	Use Case:
	Best for quick tests with static or predefined payloads.
	
	2. Map/List Approach
	Pros:
	Fully dynamic; you can construct data programmatically at runtime.
	No need for additional classes or external libraries.
	Lightweight and straightforward for simple JSON structures.
	Cons:
	Hard to read and maintain for nested JSON structures.
	More prone to logical errors due to lack of type safety.
	Not ideal for highly complex payloads.
	Use Case:
	Suitable for small and moderately dynamic JSON payloads.
	Common in simpler test frameworks or early-stage testing.
	
	3. POJO with Parameterized Constructors
	Pros:
	Highly structured and readable, closely mirroring the JSON structure.
	Easier to maintain and modify in large projects.
	Type-safe, allowing for compile-time error detection.
	Dynamic data handling via constructors or setter methods.
	Cons:
	Requires creating multiple classes, which may increase upfront effort.
	Adds dependency on serialization libraries like Jackson or Gson.
	Use Case:
	Best for complex, reusable, and frequently changing JSON payloads.
	Preferred in large, enterprise-level projects with complex API testing needs.
	
	4. POJO with Builder Pattern
	Pros:
	Combines the readability of POJOs with the flexibility of fluent APIs.
	Excellent for constructing large and complex objects with many optional fields.
	Ensures immutability and reduces the risk of invalid objects.
	Highly reusable and modular.
	Cons:
	Requires additional effort to implement the builder pattern.
	Slightly more verbose than using parameterized constructors.
	Use Case:
	Ideal for APIs with complex or hierarchical payloads where objects have many optional fields.
	Commonly used in projects emphasizing clean code and design patterns.
	
	Comparison Table:
	Criteria	            JSON String	 Map/List	POJO w/ Constructors	POJO w/ Builder
	Ease of Use	            High	     Medium	     Medium	                Medium
	Dynamic Data Handling	Low	         High	     High	                High
	Maintainability	        Low	         Low	     High	                Very High
	Readability	            Medium	     Low	     High	                Very High
	Type Safety	            None	     None	     Strong	                Strong
	Reusability	            Low	         Low	     High	                Very High
	Complexity Suitability	Low to Med 	 Medium	     High	                High
	Real-World Use	        Moderate	Occasional	 Frequent	            Frequent
	
	Recommendation: POJO with Parameterized Constructors or Builder Pattern
	
	Why POJO? It strikes the perfect balance between flexibility, readability, maintainability, and real-world usability. It is type-safe, modular, and reusable, making it ideal for enterprise-level testing.
	Why Builder Pattern? For highly complex and modular payloads, it’s a more advanced and clean approach, though it may add a slight learning curve.
	
	Real-World Practice:
	Most real-world software testing projects use POJOs with constructors or builders, 
	combined with serialization libraries like Jackson or Gson. 
	This approach aligns with software development standards, ensuring easy collaboration across teams and seamless integration with other frameworks.
	If your team frequently works with highly dynamic and complex payloads, 
	go for POJO with Builders. 
	If simplicity and flexibility are priorities, 
	POJO with Parameterized Constructors is the best choice
	
	**/
}
