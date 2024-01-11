package org.example.citybankbankecosysteminformationpeople.common.converter;

import org.example.citybankbankecosysteminformationpeople.common.domains.DTO.InformationPeopleDTO;
import org.example.citybankbankecosysteminformationpeople.common.domains.document.informationPeople.InformationPeopleDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InformationPeopleMapper
{
    InformationPeopleMapper INSTANCE = Mappers.getMapper(InformationPeopleMapper.class);

    @Mapping(target = "id", ignore = true)
    InformationPeopleDocument DTOToDocument (InformationPeopleDTO informationPeopleDTO);

    @Mapping(target = "id", ignore = true)
    InformationPeopleDTO DocumentToDTO (InformationPeopleDocument informationPeopleDocument);
}