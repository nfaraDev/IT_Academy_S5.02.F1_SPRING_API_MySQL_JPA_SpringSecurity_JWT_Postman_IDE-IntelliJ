package cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.exceptions;

import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.domainEntity.Player;

public class InvalidElementException extends RuntimeException{
    public InvalidElementException(Class type) {
        super("Id from " + type.getSimpleName() + " is invalid");
    }
}
