package com.vahabilisim.hetznercloud.connector.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Meta {

    private Pagination pagination;

    @Data
    public static class Pagination {

        private int page;
        @JsonProperty("per_page")
        private int perPage;
        @JsonProperty("previous_page")
        private int previousPage;
        @JsonProperty("next_page")
        private int nextPage;
        @JsonProperty("last_page")
        private int lastPage;
        @JsonProperty("total_entries")
        private int totalEntries;

        public boolean hasPrevious() {
            return previousPage > 0 && previousPage < page;
        }

        public boolean hasNext() {
            return nextPage > 0 && nextPage > page;
        }
    }
}
