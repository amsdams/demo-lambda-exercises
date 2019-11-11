package intro;

@FunctionalInterface
public interface IdentityFunction<T, R> {
	R apply(T t);

	static <T> IdentityFunction<T, T> indentity() {
		return t -> t;
	}
}
