package org.immutable.test;


public class Main {

  public static void main(String[] args) throws InterruptedException {
    User user1 = User.builder().username("vostapiv").password("s3cr3t").salt(12345).build();
    User user2 = User.builder().username("vostapiv").password("s3cr3t").salt(54321).build();
    System.out.println(user1 + ", salt: " + user1.getSalt());
    System.out.println(user2 + ", salt: " + user2.getSalt());
    System.out.println(user1.equals(user2));

    User user3 = User.of("jsmith", "qwe rty");
    System.out.println(user3);

    User user4 = user3.withUsername("vostapiv").withPassword("s3cr3t");
    System.out.println(user4.equals(user1));

    StagedUser stg1 =
        StagedUser.builder()
            .username("login")
            .password(Password.of("my-very-long-password"))
            .build();
    System.out.println(stg1);
    System.out.println("Created: " + stg1.getCreatedAt());
    Thread.sleep(5_000); // Lazy
    System.out.println("Accessed: " + stg1.getAccessedAt());

    StyledUser styled1 = StyledUser.builder().username("test").password("").build();
  }
}
