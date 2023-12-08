package PasswordManager.Models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SourceListResponse {
    List<SourceResponse> sourceListResponse = new ArrayList<>();
}
