package hei.school.inscription.endpoint.event.consumer.model;

import hei.school.inscription.PojaGenerated;
import hei.school.inscription.endpoint.event.model.PojaEvent;

@PojaGenerated
public record TypedEvent(String typeName, PojaEvent payload) {}
