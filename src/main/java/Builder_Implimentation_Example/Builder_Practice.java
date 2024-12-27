package Builder_Implimentation_Example;

public class Builder_Practice {
	
	private String name;
	private int age;
	
	private Builder_Practice(Builder builder) {
		this.name=builder.name;
		this.age=builder.age;
	}
	
	public static class Builder{
		
		private String name;
		private int age;
		
		public Builder setName(String name) {
			this.name=name;
			return this;
		}
		
		public Builder setAge(int age) {
			this.age=age;
			return this;
		}
		public Builder_Practice build() {
			return new Builder_Practice(this);
		}
		
	}
}
