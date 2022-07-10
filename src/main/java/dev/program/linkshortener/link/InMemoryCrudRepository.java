package dev.program.linkshortener.link;

import dev.program.linkshortener.link.api.LinkDto;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ConditionalOnProperty(havingValue = "${local.environment}")
class InMemoryCrudRepository implements CrudRepository<LinkDto, String> {

    Map<String, LinkDto> map = new HashMap<>();

    @Override
    public <S extends LinkDto> S save(S entity) {
        return (S) map.put(entity.getId(), entity);
    }

    @Override
    public <S extends LinkDto> Iterable<S> saveAll(Iterable<S> entities) {
        throw new NotImplementedException();
    }

    @Override
    public Optional<LinkDto> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<LinkDto> findAll() {
        return null;
    }

    @Override
    public Iterable<LinkDto> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(LinkDto entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends LinkDto> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
