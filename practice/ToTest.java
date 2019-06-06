import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.CONSTRUCTOR)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})// Targetアノテーションを付けることで「何につけられるアノテーションなのか？」を指定できる//{}内に引数複数可能
public @interface ToTest{}