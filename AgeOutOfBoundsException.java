public class AgeOutOfBoundsException extends RuntimeException{
    public AgeOutOfBoundsException(String message) {
        super(message);
    }
}

public void checkAge(Integer age) throws AgeOutOfBoundsException{
    if (age < 0 || age > 150){
        throw new AgeOutOfBoundsException("Age is out of bounds");
    }
}

void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
        int age = sc.nextInt();
        checkAge(age);
    } catch (AgeOutOfBoundsException e) {
        System.out.println(e.getMessage());
    }
}