package s05t02n01_llopart_gil_ismael.model.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import s05t02n01_llopart_gil_ismael.model.domain.Roll;
import s05t02n01_llopart_gil_ismael.model.dto.RollDto;

@Component 
public class RollMapperImpl implements RollMapper{

	public RollMapperImpl() {
	}

	@Override
	public List<RollDto> convertToListDto(List<Roll> rollList) {
		List<RollDto> rollDtoList = new ArrayList<>();
		
		for (Roll roll : rollList) {
			rollDtoList.add(convertToDto(roll));
		}
		
		return rollDtoList;
	}

	@Override
	public List<Roll> convertToListEntity(List<RollDto> rollListDto) {
		List<Roll> rollList = new ArrayList<>();
		
		for (RollDto rollDto : rollListDto) {
			rollList.add(convertToEntity(rollDto));
		}
		
		return rollList;
	}

	private RollDto convertToDto(Roll roll) {
		RollDto rollDto = new RollDto();
		rollDto.setId(roll.getId());
		rollDto.setFirstDice(roll.getFirstDice());
		rollDto.setSecondDice(roll.getSecondDice());
		rollDto.setResult();
		return rollDto;
	}

	private Roll convertToEntity(RollDto rollDto) {
		Roll roll = new Roll ();
		roll.setId(rollDto.getId());
		roll.setFirstDice(rollDto.getFirstDice());
		roll.setSecondDice(rollDto.getSecondDice());
		return roll;
	}
}
