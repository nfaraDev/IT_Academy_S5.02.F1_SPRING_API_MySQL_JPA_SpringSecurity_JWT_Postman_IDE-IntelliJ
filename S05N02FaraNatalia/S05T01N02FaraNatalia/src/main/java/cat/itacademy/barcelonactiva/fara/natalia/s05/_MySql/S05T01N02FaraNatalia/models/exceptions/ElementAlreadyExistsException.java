package cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.exceptions;

import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.domainEntity.Player;

public class ElementAlreadyExistsException extends RuntimeException {
    public ElementAlreadyExistsException(Class type, String name) {
        super("Element of " + type.getSimpleName() + " with name " + name + " already exists");
    }

}
