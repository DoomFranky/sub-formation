package hei.school.inscription.file.hash;

import hei.school.inscription.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
