package cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.exceptions;

public class ElementsDoesntEqualsException extends RuntimeException{
    public ElementsDoesntEqualsException(Class type, Long id, Long idDto) {
        super("Id's in " + type.getSimpleName() + " must be equals. Entered values " + id + " - "+ idDto);
    }

}
