import {
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableFooter,
    TableHead,
    TablePagination,
    TableRow,
    Paper,
    Link
} from "@material-ui/core";
import React, { useState } from "react";

function MainTableQna({ qna }) {


    const [page, setPage] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(10);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };
    return (

        <TableContainer component={Paper}>
            <Table size="small">
                <TableHead>
                    <TableRow>
                        <TableCell>No</TableCell>
                        <TableCell align="right">종류</TableCell>
                        <TableCell align="right">제목</TableCell>
                        <TableCell align="right">날짜</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {qna
                        .slice(page * rowsPerPage, (page + 1) * rowsPerPage)
                        .map(({ id, name, title, date }, i) => (

                            <TableRow key={id}>
                                <TableCell component="th" scope="row">
                                    {page * rowsPerPage + i + 1}
                                </TableCell>
                                <TableCell align="right">{name}</TableCell>

                                <TableCell align="right">
                                    <Link href="/zipcook/QuestionInfo" color="inherit" underline="hover">
                                        {title}
                                    </Link>
                                </TableCell>

                                <TableCell align="right">{date}</TableCell>
                            </TableRow>

                        ))}

                </TableBody>
                <TableFooter>
                    <TableRow>
                        <TablePagination
                            count={qna.length}
                            page={page}
                            rowsPerPage={rowsPerPage}
                            onChangePage={handleChangePage}
                            onChangeRowsPerPage={handleChangeRowsPerPage}
                        />
                    </TableRow>
                </TableFooter>
            </Table>
        </TableContainer>
    );

}

export default MainTableQna;