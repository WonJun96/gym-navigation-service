package com.example.project.gym.repository

import com.example.project.gym.entity.Gym
import com.example.project.AbstractIntegrationContainerBaseTest
import org.springframework.beans.factory.annotation.Autowired

class GymRepositoryTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private GymRepository gymRepository

    def setup() {
        gymRepository.deleteAll()
    }

    def "GymRepository save"() {
        given:
        String address = "서울 특별시 성북구 종암동"
        String name = "헐크짐"
        double latitude = 36.11
        double longitude = 128.11

        def gym = Gym.builder()
            .gymAddress(address)
            .gymName(name)
            .latitude(latitude)
            .longitude(longitude)
            .build()

        when:
        def result = gymRepository.save(gym)

        then:
        result.getGymAddress() == address
        result.getGymName() == name
        result.getLatitude() == latitude
        result.getLongitude() == longitude
    }

    def "GymRepository saveAll"() {
        given:
        String address = "서울 특별시 성북구 종암동"
        String name = "헐크짐"
        double latitude = 36.11
        double longitude = 128.11

        def gym = Gym.builder()
                .gymAddress(address)
                .gymName(name)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        gymRepository.saveAll (Arrays.asList(gym))
        def result = gymRepository.findAll()

        then:
        result.size() == 1
    }
}