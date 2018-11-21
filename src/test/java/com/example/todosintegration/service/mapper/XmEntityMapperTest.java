package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.dto.ProjectStateDTO;
import com.example.todosintegration.domain.dto.XmEntityDTO;
import com.example.todosintegration.util.TestDataUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = XmEntityMapperTest.XmEntityMapperTestConfiguration.class)
public class XmEntityMapperTest {
    @Autowired
    private XmEntityMapper xmEntityMapper;
    @SpyBean
    private DefaultDtoXmEntityMapper defaultMapper;
    @SpyBean
    @Qualifier("customProjectStateDTOMapper")
    private DtoXmEntityMapper<ProjectStateDTO> projectStateMapper;

    private XmEntity xmEntity;
    private ProjectStateDTO projectStateDTO;

    @TestConfiguration
    @ComponentScan(basePackages = "com.example.todosintegration.service.mapper")
    public static class XmEntityMapperTestConfiguration {

        @Bean
        @Order(1)
        public ProjectStateDTOMapperMock customProjectStateDTOMapper() {
            return new ProjectStateDTOMapperMock();
        }
    }

    @Before
    public void init() {
        xmEntity = TestDataUtils.buildTestXmEntity();
        projectStateDTO = TestDataUtils.buildTestProjectStateDTO();
        when(projectStateMapper.toDto(eq(xmEntity), eq(ProjectStateDTO.class))).thenReturn(projectStateDTO);
    }

    @Test
    public void testMappersOrder() {
        List<DtoXmEntityMapper> mappers = xmEntityMapper.getMappers();
        assertTrue(mappers.size() >= 2);
        DtoXmEntityMapper lastMapper = mappers.get(mappers.size() - 1);
        assertEquals(DefaultDtoXmEntityMapper.class,
                Mockito.mockingDetails(lastMapper).getMockCreationSettings().getTypeToMock());
    }

    @Test
    public void testToDtoCustomMapperInvoked() {
        ProjectStateDTO mappedDto = xmEntityMapper.toDto(xmEntity, ProjectStateDTO.class);

        verify(projectStateMapper).toDto(eq(xmEntity), eq(ProjectStateDTO.class));
        assertEquals(projectStateDTO, mappedDto);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testToDtoDefaultMapperInvoked() {
        XmEntityDTO dto = new XmEntityDTO() {
        };
        doReturn(dto).when(defaultMapper).toDto(any(), any());
        xmEntityMapper.toDto(xmEntity, dto.getClass());

        verify(defaultMapper).toDto(eq(xmEntity), any());
    }

    public static class ProjectStateDTOMapperMock implements DtoXmEntityMapper<ProjectStateDTO> {

        @Override
        public boolean supports(Class<? extends XmEntityDTO> dtoClass) {
            return dtoClass == ProjectStateDTO.class;
        }
    }
}