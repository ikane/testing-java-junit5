package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelImpl;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    VetController vetController;
    VetService vetService;
    SpecialityMapService specialityMapService;
    List<Speciality> specialities = Arrays.asList(
            new Speciality(1l, "Speciality1"),
            new Speciality(2l, "Speciality2"));

    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();
        specialityMapService.save(specialities.get(0));
        specialityMapService.save(specialities.get(1));
        vetService = new VetMapService(specialityMapService);
        vetController = new VetController(vetService);
    }

    @Test
    void listVets() {
        //Given
        Model model = new ModelImpl();
        HashSet<Speciality> specialitySet = new HashSet<>();
        specialitySet.add(specialities.get(0));
        Vet vet1 = new Vet(1l, "vet1", "vet1", specialitySet);
        Vet vet2 = new Vet(2l, "vet2", "vet2", specialitySet);
        vetService.save(vet1);
        vetService.save(vet2);

        //When
        String result = this.vetController.listVets(model);

        //Then
        Assertions.assertThat(result).isEqualTo("vets/index");
        Map<String, Object> modelMaps = ((ModelImpl) model).getModelMaps();

        Assertions.assertThat(modelMaps).isNotEmpty();
        Assertions.assertThat(((Set)modelMaps.get("vets")).size()).isEqualTo(2);
        //Assertions.assertThat(((ModelImpl) model).getModelMaps().containsValue(vet1)).isTrue();
    }
}