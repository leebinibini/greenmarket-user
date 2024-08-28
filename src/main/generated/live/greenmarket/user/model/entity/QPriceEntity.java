package live.greenmarket.user.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPriceEntity is a Querydsl query type for PriceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPriceEntity extends EntityPathBase<PriceEntity> {

    private static final long serialVersionUID = -1178475176L;

    public static final QPriceEntity priceEntity = new QPriceEntity("priceEntity");

    public final NumberPath<Integer> Id = createNumber("Id", Integer.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> surcharge = createNumber("surcharge", Integer.class);

    public QPriceEntity(String variable) {
        super(PriceEntity.class, forVariable(variable));
    }

    public QPriceEntity(Path<? extends PriceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPriceEntity(PathMetadata metadata) {
        super(PriceEntity.class, metadata);
    }

}

